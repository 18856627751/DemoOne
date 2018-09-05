#include <jni.h>

JNIEXPORT void JNICALL
Java_com_ben_pailitaodemo_myapplication_Watcher_createWatcher(JNIEnv *env, jobject instance,
                                                              jstring keyId_) {
    const char *keyId = (*env)->GetStringUTFChars(env, keyId_, 0);

    // TODO

    (*env)->ReleaseStringUTFChars(env, keyId_, keyId);
}