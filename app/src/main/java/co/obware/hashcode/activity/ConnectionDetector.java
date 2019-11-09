package co.obware.hashcode.activity;


import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;



public class ConnectionDetector {

    private Context context;
    
    // A constructor that takes a context.
    public ConnectionDetector(Context context) {

        this.context = context;
    }
    


    // A boolean method that returns true if there's internet connectivity and false if otherwise.
    public boolean isConnected(){

        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Service.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {

            NetworkInfo info = connectivityManager.getActiveNetworkInfo();

            if (info != null)
               return info.getState() == NetworkInfo.State.CONNECTED;
        }

        return false;
    }


    // A void method that outputs takes a context, title and message to display an alert dialog if there's no internet connection 
    public void alertDialog(Context context, String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}
