LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE :=  test
LOCAL_LALIBS+=llog
LOCAL_SRC_FILES :=  com_jingju_jnitest_Test.cpp
include $(BUILD_SHARED_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE :=  threads
LOCAL_LALIBS+=llog
LOCAL_SRC_FILES :=  com_jingju_jnitest_Threads.cpp
include $(BUILD_SHARED_LIBRARY)