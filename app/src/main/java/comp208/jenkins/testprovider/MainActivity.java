package comp208.jenkins.testprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String TAG = "--";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver contentResolver = getContentResolver();
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("content").authority(TestContentProvider.Contract.AUTHORITY); // always going to be content, check manifest for authority. Made authority function in TestContentProvider.java
        Uri uri = builder.build();

        Log.i(TAG,"OnCreate: "+ uri.toString());

        Cursor cursor = contentResolver.query(uri,null,null,null,null);

        Log.i(TAG,"onCreate " + "query returned");

        if (cursor == null)
        {
            Log.i(TAG,"OnCreate: "+ "cursor is NULL");
        }
        else{
            while (cursor.moveToNext())
            {
                Log.i(TAG, "onCreate: " + cursor.getInt(0)+ " " + cursor.getString(1));
            }
            cursor.close();
        }
    }
}