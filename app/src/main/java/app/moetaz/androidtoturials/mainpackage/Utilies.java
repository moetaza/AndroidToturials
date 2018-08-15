package app.moetaz.androidtoturials.mainpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.design.widget.Snackbar;
import android.view.View;

public class Utilies {

    public interface Action{
        void undo();
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }



    public static void showSnack(View view, String snackMessage, final String undoMessage, final Action action){
        Snackbar snackbar = Snackbar
                .make(view, snackMessage, Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(view, undoMessage, Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                        action.undo();
                    }
                });

        snackbar.show();
    }
}
