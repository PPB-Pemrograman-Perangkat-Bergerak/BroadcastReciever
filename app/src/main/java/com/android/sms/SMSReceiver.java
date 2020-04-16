package com.android.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class SMSReceiver extends BroadcastReceiver
{
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onReceive(Context context, Intent intent)
    {
//---get the SMS message passed in---
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;
        String str = "SMS Dari ";
        if (bundle != null)
        {
            int i;
//---retrieve the SMS message received---
            msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            for ( i=0; i<msgs.length; i++){
                str += msgs[i].getMessageBody().toString();
            }
//---get the message body---
            str += msgs[i].getMessageBody().toString();
        }
//---display the new SMS message---
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
        Log.d("SMS Receiver Disini", str);
    }
}