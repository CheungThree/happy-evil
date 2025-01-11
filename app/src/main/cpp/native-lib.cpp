#include <stdlib.h>

#include "com_example_lyt_App.h"
#include "consts.h"
jstring Java_com_example_lyt_App_hello(JNIEnv *const e, jobject) {
  /*e = (JNIEnv *)0;*/
  return e->NewStringUTF(C::hlw);
}