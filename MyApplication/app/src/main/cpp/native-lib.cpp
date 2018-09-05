#include <jni.h>
#include <string>
#include <unistd.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <sys/un.h>
#include <sys/select.h>
#include <signal.h>
#include <pthread.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/un.h>
#include <errno.h>
#include <linux/signal.h>

#include <android/log.h>
#include "native.h"

const char *PATH="/data/data/com.ben.pailitaodemo.myapplication/mySocket";
const char *userId;
int m_child=0;
extern "C" JNIEXPORT jstring

JNICALL
Java_com_ben_pailitaodemo_myapplication_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

int child_create_channel(){
    /**
     * 创建socket
     * @param __af  协议
     * @param __type socket类型 （本地）
     * @param __protocol 具体地址 0表示本地
     */
    int listener=socket(AF_LOCAL, SOCK_STREAM, 0);

    struct sockaddr_un addr;
    //addr内存区域不为零，清空
    memset(&addr,0, sizeof(sockaddr));
    addr.sun_family=AF_LOCAL;
    stpcpy(addr.sun_path,PATH);

    if(bind(listener,(const sockaddr*)&addr, sizeof(sockaddr_un))<0){
        //返回错误
        //LOGE("");
        return 0;
    }

    int connfd;
    listen(listener,5);
    //保证宿主进程连接成功
    while (1){
        //返回值

        if((connfd=accept(listener, NULL, NULL)) < 0){
            if(errno==EINTR){
                continue;
            }else{
                //读取错误
                return 0;
            }
        }

        m_child=connfd;
        break;
    }
    return 1;
}

void child_listen_msg(){
    fd_set rf;

    struct timeval timeout={3,0};
    while(1){
        FD_ZERO(&rf);
        FD_SET(m_child,&rf);
        int time=select(m_child+1,&rf,NULL,NULL,&timeout);
        if(time>0){
            char pkg[256]={0};
            if(FD_ISSET(m_child,&rf)){
                int result=read(m_child,pkg, sizeof(pkg));
                execlp("am","am","startservice","--use",userId,
                       "com.ben.pailitaodemo.myapplication/com.ben.pailitaodemo.myapplication.ProcessService",(char*)NULL);
            }
        }

    }
}

void child_do_work() {
    if(child_create_channel()){
        child_listen_msg();
    }
}


extern "C"
JNIEXPORT void JNICALL
Java_com_ben_pailitaodemo_myapplication_Watcher_createWatcher(JNIEnv *env, jobject instance,jstring keyId_) {


    userId=env->GetStringUTFChars(keyId_,0);
    // NDK守护双进程
    pid_t pid=fork();
    if(pid<0){
        //fork失败
    } else if(pid==0){
        //子进程，当前进程
        child_do_work();
    }else{
       //父进程
    }
}extern "C"
JNIEXPORT void JNICALL
Java_com_ben_pailitaodemo_myapplication_Watcher_createConnect(JNIEnv *env, jobject instance,
                                                              jstring keyId_) {
    const char *keyId = env->GetStringUTFChars(keyId_, 0);



    env->ReleaseStringUTFChars(keyId_, keyId);
}