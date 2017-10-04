package mx.edu.utng.pcamacho.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner cmbMenus;
    Spinner cmbMenuSeleccionado;
    Button btnAgregarPlatillo;
    Button btnmostrarOrden;
    String[] desayunos={"huevos a la Mexicana","chilaquiles","Jugo de naranja","Coctel de Frutas","Hotcakes","Crepas"};
    String [] comidas={"Chiles rellenos","Pollo empanizado","Enchiladas Verdes","Enchiladas Rojas","Mole de Ollas"};
    String [] cena={"Tacos de Pastor","Quesadillas","Pozole","Chocolate"};
    ArrayAdapter<String> adapter;
    MenuComponent desayunosMenu=new Menu("Menu de desayuno","Desayunos");
    MenuComponent comidasMenunew = new Menu("Menu de Comidas","Comidas");
    MenuComponent cenasMenu  = new Menu("Menu de Cenas","Cenas");
    MenuComponent allMenus  = new Menu("Todos los menus ","Menu Combinado");
    TextView txtOrden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cmbMenus=(Spinner)findViewById(R.id.cmb_menus);
        cmbMenuSeleccionado=(Spinner)findViewById(R.id.cmb_menu_disponible);
        btnAgregarPlatillo=(Button)findViewById(R.id.btn_agregar);
        btnmostrarOrden=(Button)findViewById(R.id.btn_mostrar_orden);
        txtOrden=(TextView)findViewById(R.id.txt_orden);
        adapter =new ArrayAdapter<String>(this,R.layout.spinner_item,desayunos);
        cmbMenuSeleccionado.setAdapter(adapter);
        cmbMenus.setOnItemSelectedListener(this);

        btnAgregarPlatillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int m=(int)cmbMenus.getSelectedItem();
                int p=(int)cmbMenuSeleccionado.getSelectedItem();
                MenuItem menuItem=null;
                switch (m){
                    case 0://desayuno
                        switch (p){
                            case 0://huevos a la mexicana
                                menuItem= new MenuItem("huevos a la Mexicana","chilaquiles", true, 25.0);
                                break;
                            case 1://Chilaquiles
                                menuItem= new MenuItem("chilaquiles","huevos a la Mexicana", true, 20.0);
                                break;
                        }//fin del switch desayuno
                        desayunosMenu.add(menuItem);
                        Toast.makeText(getApplicationContext(),"Se agregó un platillo",Toast.LENGTH_SHORT).show();
                        break;
                    case 1://Comidas
                        switch (p){
                            case 0://chiles rellenos
                                menuItem= new MenuItem("Chiles rellenos","Pollo empanizado", true, 25.0);
                                break;
                            case 1://Pollo empanizado
                                menuItem= new MenuItem("Pollo empanizado","Chiles rellenos", false, 20.0);
                                break;
                        }//fin del switch comidas
                        comidasMenunew.add(menuItem);
                        Toast.makeText(getApplicationContext(),"Se agregó un platillo",Toast.LENGTH_SHORT).show();
                        break;
                    case 2://Cenas
                        switch (p){
                            case 0://chiles rellenos
                                menuItem= new MenuItem("Tacos de Pastor","Quesadillas", true, 20.0);
                                break;
                            case 1://Quesadillas
                                menuItem= new MenuItem("Quesadillas","Tacos de Pastor", true, 20.0);
                                break;
                        }//fin del switch cenas
                        cenasMenu.add(menuItem);
                        Toast.makeText(getApplicationContext(),"Se agregó un platillo",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        btnmostrarOrden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allMenus.add(desayunosMenu);
                allMenus.add(comidasMenunew);
                allMenus.add(cenasMenu);
                //Toast.makeText(getApplicationContext(),"Se agregó un platillo",Toast.LENGTH_SHORT).show();
                txtOrden.setText(allMenus.print());
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?>  adapterView, View view, int position, long id) {
        int m=0;//menu
        if (adapterView.getId() == R.id.cmb_menus) {//primer menu
            m=(int)cmbMenus.getSelectedItemId();
            switch ((int)cmbMenus.getSelectedItemId()) {
                case 0:

                    adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, desayunos);
                    cmbMenuSeleccionado.setAdapter(adapter);

                    break;
                case 1:
                    adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, comidas);
                    cmbMenuSeleccionado.setAdapter(adapter);
                    break;
                case 2:
                  adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, cena);
                    cmbMenuSeleccionado.setAdapter(adapter);
                    break;

            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
