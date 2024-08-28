#include <jni.h>
#include <GLES2/gl2.h>

void on_surface_created() {
    glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
}

void on_surface_changed() {
    // No-op
}

void on_draw_frame() {
    glClear(GL_COLOR_BUFFER_BIT);
}

JNIEXPORT void JNICALL
Java_com_rekoj134_nativecandroiddemo_RendererWrapper_on_1draw_1frame(JNIEnv *env, jobject thiz) {
    on_draw_frame();
}

JNIEXPORT void JNICALL
Java_com_rekoj134_nativecandroiddemo_RendererWrapper_on_1surface_1changed(JNIEnv *env,
                                                                          jobject thiz) {
    on_surface_changed();
}

JNIEXPORT void JNICALL
Java_com_rekoj134_nativecandroiddemo_RendererWrapper_on_1surface_1created(JNIEnv *env,
                                                                          jobject thiz) {
    on_surface_created();
}