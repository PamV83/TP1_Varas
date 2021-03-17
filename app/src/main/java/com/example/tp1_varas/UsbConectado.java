package com.example.tp1_varas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.widget.Toast;

    //Creo el broadcast
    public class UsbConectado extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.hardware.usb.action.USB_STATE");
        boolean conectado = (intent.getExtras().getBoolean("connected"));
        if (conectado) {
            Toast.makeText(context, "Iniciando llamada", Toast.LENGTH_LONG).show();
            Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel: "+" 1164369842")); //cambio de número

            context.startActivity(i);

        } else {
            Toast.makeText(context, "Llamada no iniciada", Toast.LENGTH_LONG).show();

        }
    }
}

