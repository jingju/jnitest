//
// Created by Macro on 2021/3/23.
//

#ifndef JNITEST_COMMON_TOOLS_H
#define JNITEST_COMMON_TOOLS_H
#include <android/log.h>

//jni日志的封装
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define LOGE(...)  __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)

#endif //JNITEST_COMMON_TOOLS_H
