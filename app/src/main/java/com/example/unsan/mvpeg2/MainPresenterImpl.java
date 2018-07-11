package com.example.unsan.mvpeg2;

public class MainPresenterImpl implements MainPresenter, GetQuoteInteractor.OnFinishedListener {
    private MainInterface mainInterface;
    private GetQuoteInteractor getQuoteInteractor;
    public MainPresenterImpl(MainInterface mainView, GetQuoteInteractor getQuoteInteractor) {
        this.mainInterface = mainView;
        this.getQuoteInteractor = getQuoteInteractor;
    }

    @Override
    public void onFinished(String string) {
        if (mainInterface != null) {
            mainInterface.setQuote(string);
            mainInterface.hideProgress();
        }

    }

    @Override
    public void onButtonClick() {
        if (mainInterface != null) {
            mainInterface.showProgress();
        }

        getQuoteInteractor.getNextQuote(this);

    }

    @Override
    public void onDestroy() {
        mainInterface = null;

    }
}
