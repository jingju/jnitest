//
// Created by Macro on 2021/3/31.
//

#ifndef JNITEST_COMMON_H
#define JNITEST_COMMON_H
#include <jni.h>

void ThrowException(JNIEnv * env,
        const char* className,
        const char* message);


#endif //JNITEST_COMMON_H
