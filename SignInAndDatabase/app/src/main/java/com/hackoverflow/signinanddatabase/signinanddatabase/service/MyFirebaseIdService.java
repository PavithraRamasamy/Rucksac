package com.hackoverflow.signinanddatabase.signinanddatabase.service;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.hackoverflow.signinanddatabase.signinanddatabase.Common;

public class MyFirebaseIdService extends FirebaseInstanceIdService{
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Common.currentToken = refreshedToken;
    }
}
