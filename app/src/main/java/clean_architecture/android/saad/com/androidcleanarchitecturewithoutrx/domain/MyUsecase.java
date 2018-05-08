package clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.domain;

import clean_architecture.android.saad.com.androidcleanarchitecturewithoutrx.base.domain.UseCase;

public class MyUsecase extends UseCase<MyUsecase.RequestValues,MyUsecase.ResponseValue> {
    @Override
    protected void executeUseCase(RequestValues requestValues) {

    }

    class RequestValues implements UseCase.RequestValues{

    }
    class ResponseValue implements UseCase.ResponseValue{

    }
}
