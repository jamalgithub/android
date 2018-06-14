package team.dev.com.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        setTitle("Recycle List");

        final RecyclerView rv = (RecyclerView) findViewById(R.id.list);
        //LinearLayoutManagerest est l’objet responsable, au sein du RecyclerView, d’afficher les vues verticalement, de haut en bas.
        rv.setLayoutManager(new LinearLayoutManager(this));
        //L’adapter est une classe responsable du contenu et des vues qui l’affichent.
        rv.setAdapter(new MyAdapter());
    }
}
