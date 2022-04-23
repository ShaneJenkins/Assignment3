package comp208.jenkins.testprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Log;

public class TestContentProvider extends ContentProvider {
    public TestContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    String TAG ="--++";
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        Log.i(TAG,"query: " + "Inside content provider");
        /**
         * This method typically runs a database query, or make a request to a remote API
         */

        String[] columnNames = {"_id", "data" }; // first column has to be _id or it will break
        MatrixCursor mc = new MatrixCursor(columnNames);
        MatrixCursor.RowBuilder rb;
        rb = mc.newRow();
        rb.add("_id",1);
        rb.add("data","This is data item 1");

        rb = mc.newRow();
        rb.add("_id",2);
        rb.add("data","This is data item 2");


        return mc;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public static class Contract{
        public static final String AUTHORITY = "test.provider";
        public static final String[] columnNames = {"_id", "data"};

    }



}