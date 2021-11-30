package dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ConnectionHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="votos.db";
    private static final int VERSION = 1;


    public ConnectionHelper(Context context){
        super(context, "votos.db", null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //EN SQL LITE PODEMOS OMITIR EL AUTOINCREMENT SINO SE INSERTA UN ID ESPECIFICO AUTOMATICAMENTE INCREMENTARÁ
        String sql1="CREATE TABLE votos (id_voto INTEGER PRIMARY KEY," +
                "voto_blanco integer, " +
                "voto_nulo integer," +
                "voto_boric integer," +
                "voto_kast integer" +
                ");";
        sqLiteDatabase.execSQL("PRAGMA foreign_key = ON;");
        sqLiteDatabase.execSQL(sql1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE votos");
        onCreate(sqLiteDatabase);
    }
}