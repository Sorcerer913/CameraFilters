package max.go.cameratest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TableRow;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private static final  int CAMERA_REQUEST = 0;
    private ImageView imageView;
    private GridLayout grid;
    private Bitmap bitmap;

        public String TAG = "MainActivity";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            imageView = findViewById(R.id.imageview);
            grid = findViewById(R.id.gridlayout);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);

                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
    }

    GridImageViewGenerator imgVGen = new GridImageViewGenerator() {
        @Override
        public void addImageView(GridLayout grd) {
            ImageView imageView = new ImageView(grd.getContext());

            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.width = GridLayout.LayoutParams.WRAP_CONTENT;
            layoutParams.height = GridLayout.LayoutParams.MATCH_PARENT;
//            GridLayout.Spec rowSpec = new
//            GridLayout.LayoutParams layP = new GridLayout.LayoutParams();
            TableRow.LayoutParams lp = new TableRow.LayoutParams();
            lp.weight = 1;
            //TODO: rowWeight into layoutParams

            //layoutParams.columnSpec = new
            imageView.setLayoutParams(layoutParams);

            grd.addView(imageView);
            //imageView.setLayoutParams(new GridLayout.LayoutParams());

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            // Фотка сделана, извлекаем картинку
            bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);

            for (int i = 0; i < 10; i++) {
                imgVGen.addImageView(grid);
                ImageView imageView1 = (ImageView) grid.getChildAt(grid.getChildCount()-1);
                //imageView.setImageBitmap(Monochrome.makeMonochrome(bitmap));
                imageView1.setImageBitmap(bitmap);
            }


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
