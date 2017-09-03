package alvi17.bangladeshemergencynumbers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by User on 8/30/2017.
 */

public class Util {

    public static void call(Context context,String userphone) {

        if (!userphone.equals("")) {

            try {
                Intent callIntent = new Intent(Intent.ACTION_CALL);

                callIntent.setData(Uri.parse("tel:" + userphone));
                try {
                    context.startActivity(callIntent);

                } catch (SecurityException e) {
                    Log.e(context.getClass().getSimpleName(), e.toString());
                }
            } catch (Exception activityException) {
                Log.d("Calling", "Call failed", activityException);
            }
        }
        else {
            Toast.makeText(context.getApplicationContext(),"Try manual dial",Toast.LENGTH_SHORT).show();
        }
    }

//    static Toast toast;
//    public static void showCustomToast(Context context,String msg)
//    {
//        LayoutInflater inflater = context.getLayoutInflater();
//        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.toast_layout_root));
//        if(toast!=null) {
//            toast.cancel();
//        }
//        toast = new Toast(context.getApplicationContext());
//        TextView textView=(TextView)layout.findViewById(R.id.toast_textView);
//        textView.setText(msg);
//        toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
//        toast.setDuration(Toast.LENGTH_SHORT);
//        toast.setView(layout);
//        toast.show();
//    }

}
