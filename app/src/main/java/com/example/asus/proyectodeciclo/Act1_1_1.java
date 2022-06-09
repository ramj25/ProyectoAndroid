package com.example.asus.proyectodeciclo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Act1_1_1 extends AppCompatActivity {

    ArrayList<Posicion> pos = new ArrayList<Posicion>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1_1_1);

     /*   Bundle bdl = getIntent().getExtras();
       ArrayList<Partido> misPartidos =bdl.getParcelable("listaEq");
        Bundle bundle = getIntent().getExtras();
        String id=bundle.getString("id1");

        int numeroGrupo=Integer.parseInt(id); */


        ArrayList<Partido> misPartidos = (ArrayList<Partido>) getIntent().getSerializableExtra("listaEq");
        Bundle bundle = getIntent().getExtras();
        String grupo=bundle.getString("grupo");

        String et="Grupo "+Character.toString ((char)(Integer.parseInt(grupo)+64));

        TextView txtM=findViewById(R.id.txtM);

        txtM.setText(et);

/*
        for(int i=0;i<6;i++){
            if(misPartidos.get(i).getGoles1()==null){misPartidos.get(i).setGoles1();}
        } */

        TextView txt11 = findViewById(R.id.txt11);
        TextView txt12 = findViewById(R.id.txt12);


        TextView txt21 = findViewById(R.id.txt21);
        TextView txt22 = findViewById(R.id.txt22);


        TextView txt31 = findViewById(R.id.txt31);
        TextView txt32 = findViewById(R.id.txt32);


        TextView txt41 = findViewById(R.id.txt41);
        TextView txt42 = findViewById(R.id.txt42);


        TextView txt51 = findViewById(R.id.txt51);
        TextView txt52 = findViewById(R.id.txt52);


        TextView txt61 = findViewById(R.id.txt61);
        TextView txt62 = findViewById(R.id.txt62);


        txt11.setText(misPartidos.get(0).getDetalles());
        txt21.setText(misPartidos.get(1).getDetalles());
        txt31.setText(misPartidos.get(2).getDetalles());
        txt41.setText(misPartidos.get(3).getDetalles());
        txt51.setText(misPartidos.get(4).getDetalles());
        txt61.setText(misPartidos.get(5).getDetalles());

        if (misPartidos.get(0).getGoles1() == null) {
            txt12.setText(misPartidos.get(0).getEquipo1() + " - " + misPartidos.get(0).getEquipo2());
        } else {
            txt12.setText(misPartidos.get(0).getEquipo1() + " " + misPartidos.get(0).getGoles1() + " - " + misPartidos.get(0).getGoles2() + " " + misPartidos.get(0).getEquipo2());
        }

        if (misPartidos.get(1).getGoles1() == null) {
            txt22.setText(misPartidos.get(1).getEquipo1() + " - " + misPartidos.get(1).getEquipo2());
        } else {
            txt22.setText(misPartidos.get(1).getEquipo1() + " " + misPartidos.get(1).getGoles1() + " - " + misPartidos.get(1).getGoles2() + " " + misPartidos.get(1).getEquipo2());
        }

        if (misPartidos.get(2).getGoles1() == null) {
            txt32.setText(misPartidos.get(2).getEquipo1() + " - " + misPartidos.get(2).getEquipo2());
        } else {
            txt32.setText(misPartidos.get(2).getEquipo1() + " " + misPartidos.get(2).getGoles1() + " - " + misPartidos.get(2).getGoles2() + " " + misPartidos.get(2).getEquipo2());
        }

        if (misPartidos.get(3).getGoles1() == null) {
            txt42.setText(misPartidos.get(3).getEquipo1() + " - " + misPartidos.get(3).getEquipo2());
        } else {
            txt42.setText(misPartidos.get(3).getEquipo1() + " " + misPartidos.get(3).getGoles1() + " - " + misPartidos.get(3).getGoles2() + " " + misPartidos.get(3).getEquipo2());
        }

        if (misPartidos.get(4).getGoles1() == null) {
            txt52.setText(misPartidos.get(4).getEquipo1() + " - " + misPartidos.get(4).getEquipo2());
        } else {
            txt52.setText(misPartidos.get(4).getEquipo1() + " " + misPartidos.get(4).getGoles1() + " - " + misPartidos.get(4).getGoles2() + " " + misPartidos.get(4).getEquipo2());
        }

        if (misPartidos.get(5).getGoles1() == null) {
            txt62.setText(misPartidos.get(5).getEquipo1() + " - " + misPartidos.get(5).getEquipo2());
        } else {
            txt62.setText(misPartidos.get(5).getEquipo1() + " " + misPartidos.get(5).getGoles1() + " - " + misPartidos.get(5).getGoles2() + " " + misPartidos.get(5).getEquipo2());
        }


        //Llenado de tablas

        for (int i = 0; i < 6; i++) {


            Boolean c1 = true;
            Boolean c2 = true;
            String eq1 = misPartidos.get(i).getEquipo1();
            String eq2 = misPartidos.get(i).getEquipo2();
            Integer gl1 = misPartidos.get(i).getGoles1();
            Integer gl2 = misPartidos.get(i).getGoles2();


            for (Posicion posicion : pos) {
                if (posicion.getNM().equals(eq1)) {
                    c1 = false;
                    break;
                }
            }
            if (c1 == true) {
                pos.add(new Posicion(eq1, 0, 0, 0, 0, 0, 0, 0, 0));
            }


            for (Posicion posicion : pos) {
                if (posicion.getNM().equals(eq2)) {
                    c2 = false;
                    break;
                }
            }
            if (c2 == true) {
                pos.add(new Posicion(eq2, 0, 0, 0, 0, 0, 0, 0, 0));
            }


            if (gl1 != null) {

                for (Posicion posicion : pos) {
                    if (posicion.getNM().equals(eq1) || posicion.getNM().equals(eq2)) {
                        posicion.setPJ(posicion.getPJ() + 1);
                    }
                }
            }

            if (gl1 != null && gl2 != null) {

                for (Posicion posicion : pos) {
                    if (posicion.getNM().equals(eq1)) {

                        posicion.setGF(posicion.getGF() + gl1);
                        posicion.setGC(posicion.getGC() + gl2);

                        if (gl1 > gl2) {
                            posicion.setPG(posicion.getPG() + 1);
                        } else if (gl1 == gl2) {
                            posicion.setPE(posicion.getPE() + 1);
                        } else {
                            posicion.setPP(posicion.getPP() + 1);
                        }

                    }
                    if (posicion.getNM().equals(eq2)) {

                        posicion.setGF(posicion.getGF() + gl2);
                        posicion.setGC(posicion.getGC() + gl1);

                        if (gl1 < gl2) {
                            posicion.setPG(posicion.getPG() + 1);
                        } else if (gl1 == gl2) {
                            posicion.setPE(posicion.getPE() + 1);
                        } else {
                            posicion.setPP(posicion.getPP() + 1);
                        }
                    }
                }
            }
        }

        for (Posicion posicion : pos) {

            posicion.setDG(posicion.getGF() - posicion.getGC());
            posicion.setPT((posicion.getPG() * 3) + posicion.getPE());
        }


//Prueba


/*
String abc="";
String a ="";
        String b ="";
        String c ="";
        String d ="";
        String e="";
        String f="";
        String g="";
        String h="";

      for(Posicion aaa:pos){abc=abc+aaa.getNM();  a= a+aaa.getPJ(); b= b+aaa.getPG(); c= c+aaa.getPE(); d= d+aaa.getPP(); e=e+aaa.getGF(); f=f+aaa.getGC(); g=g+aaa.getDG(); h=h+aaa.getPT(); }

System.out.println(abc);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);


*/

        BaseDeDatos bd = new
                BaseDeDatos(this, "BD", null, 1);

        //Eliminacion (limpieza) de los datos de la tabla

        SQLiteDatabase BD = bd.getWritableDatabase();
        BD.delete("posiciones", null, null);

        //Insercion de los datos del grupo de este activity (La actualizacion de los datos es automatica por medio de servicios)

        for (Posicion posicion : pos) {

            ContentValues valores = new ContentValues();
            valores.put("NM", posicion.getNM());
            valores.put("PJ", posicion.getPJ());
            valores.put("PG", posicion.getPG());
            valores.put("PE", posicion.getPE());
            valores.put("PP", posicion.getPP());
            valores.put("GF", posicion.getGF());
            valores.put("GC", posicion.getGC());
            valores.put("DG", posicion.getDG());
            valores.put("PT", posicion.getPT());
            BD.insert("posiciones", null, valores);

        }

        BD.close();

        //Ejecucion del Select ordenando la lista

        SQLiteDatabase BD2 = bd.getReadableDatabase();

        Cursor cursor = BD2.rawQuery("SELECT * FROM posiciones ORDER BY PT DESC;", null);


        List<Posicion> ordenada = new ArrayList<>();
        if (cursor.moveToFirst()) {

            do {
                String v0 = cursor.getString(0);
                int v1 = cursor.getInt(1);
                int v2 = cursor.getInt(2);
                int v3 = cursor.getInt(3);
                int v4 = cursor.getInt(4);
                int v5 = cursor.getInt(5);
                int v6 = cursor.getInt(6);
                int v7 = cursor.getInt(7);
                int v8 = cursor.getInt(8);
                ordenada.add(new Posicion(v0, v1, v2, v3, v4, v5, v6, v7, v8));
            } while (cursor.moveToNext());
        }
        cursor.close();
        BD2.close();


/*
        String abc="";
        String a ="";
        String b ="";
        String c ="";
        String d ="";
        String e="";
        String f="";
        String g="";
        String h="";

        for(Posicion aaa:ordenada){abc=abc+aaa.getNM();  a= a+aaa.getPJ(); b= b+aaa.getPG(); c= c+aaa.getPE(); d= d+aaa.getPP(); e=e+aaa.getGF(); f=f+aaa.getGC(); g=g+aaa.getDG(); h=h+aaa.getPT(); }

        System.out.println(abc);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);

*/

        TableLayout tb1 = findViewById(R.id.tb1);


        for (Posicion p : ordenada) {
            TableRow row = new TableRow(this);
            /*row.getLayoutParams().width= ViewGroup.LayoutParams.MATCH_PARENT;
            row.getLayoutParams().height=ViewGroup.LayoutParams.MATCH_PARENT;*/
            /*TableLayout.LayoutParams params = new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 0, 1f);
            row.setLayoutParams(params);*/
            /*row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));*/
            TextView t  = new TextView(this);
            t.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 6f));
            TextView t1 = new TextView(this);
            t1.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 1f));
            TextView t2 = new TextView(this);
            t2.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 1f));
            TextView t3 = new TextView(this);
            t3.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 1f));
            TextView t4 = new TextView(this);
            t4.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 1f));
            TextView t5 = new TextView(this);
            t5.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 1f));
            TextView t6 = new TextView(this);
            t6.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 1f));
            TextView t7 = new TextView(this);
            t7.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 1f));
            TextView t8 = new TextView(this);
            t8.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT, 1f));

            t.setText(p.getNM());
            t1.setText(p.getPJ() + "");
            t2.setText(p.getPG() + "");
            t3.setText(p.getPE() + "");
            t4.setText(p.getPP() + "");
            t5.setText(p.getGF() + "");
            t6.setText(p.getGC() + "");
            t7.setText(p.getDG() + "");
            t8.setText(p.getPT() + "");

            row.addView(t);
            row.addView(t1);
            row.addView(t2);
            row.addView(t3);
            row.addView(t4);
            row.addView(t5);
            row.addView(t6);
            row.addView(t7);
            row.addView(t8);

            tb1.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));


        }
    }
}
