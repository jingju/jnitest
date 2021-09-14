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


include $(CLEAR_VARS)
LOCAL_MODULE :=  echo
LOCAL_LALIBS+=llog
LOCAL_SRC_FILES :=  com_jingju_jniTest_Echo.cpp
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE :=  AVIPlayer
LOCAL_LALIBS+=llog
LOCAL_SRC_FILES :=Common.cpp\
com_jingju_jniTest_AVIPlayer.cpp

#使用AVLib静态库
LOCAL_STATIC_LIBRARIES +=avilib_static
include $(BUILD_SHARED_LIBRARY)

#引入AVILib库模块
$(call import-module,transcode-1.1.7/avilib)