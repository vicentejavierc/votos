package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Voto;

public class DaoVoto {

    private ConnectionHelper helper;
    private ContentValues contentValues;
    private SimpleDateFormat dateFormat;

    public DaoVoto(Context context){
        helper = new ConnectionHelper(context);
        contentValues = new ContentValues();
    }

    public String insert(Voto v){
        SQLiteDatabase db = helper.getWritableDatabase();
        contentValues.clear();
        contentValues.put("voto_blanco",v.getVoto_blaco());
        contentValues.put("voto_nulo", v.getVoto_nulo());
        contentValues.put("voto_boric", v.getVoto_boric());
        contentValues.put("voto_kast", v.getVoto_kast());

        long x = db.insert("voto", null, contentValues);
        db.close();
        return x+"";
    }




    public List<Voto> getVotos(){
        List<Voto> list =  new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT sum(voto_blanco), sum(voto_nulo), sum(voto_boric), sum(voto_kast) FROM votos";
        Cursor cursor = db.rawQuery(sql, null);

        try {
            while (cursor.moveToNext()) {
                Voto pet = new Voto();
                pet.setVoto_blaco(Integer.parseInt(cursor.getString(0)));
                pet.setVoto_nulo(Integer.parseInt(cursor.getString(1)));
                pet.setVoto_boric(Integer.parseInt(cursor.getString(2)));
                pet.setVoto_kast(Integer.parseInt(cursor.getString(3)));
                list.add(pet);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            db.close();
        }

        return list;
    }



}



