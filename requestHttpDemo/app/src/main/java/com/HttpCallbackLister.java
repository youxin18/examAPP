package com;

public interface HttpCallbackLister {
    void onFinish(String response);
    void onError(Exception e);
}
