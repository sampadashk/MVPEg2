package com.example.unsan.mvpeg2;

public interface GetQuoteInteractor {
    interface OnFinishedListener
    {
        public void onFinished(String string);
    }
    void getNextQuote(OnFinishedListener listener);


}
