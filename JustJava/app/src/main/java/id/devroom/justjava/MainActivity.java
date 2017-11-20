package id.devroom.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int jumlahKopi = 0;

    CheckBox cbGula, cbCream, cbLolipop, cbKopi;
    String pesan;
    int j = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbGula = findViewById(R.id.ckGula);
        cbCream = findViewById(R.id.ckKrim);
        cbLolipop = findViewById(R.id.ckLollipop);
        cbKopi = findViewById(R.id.ckKopi);

    }
    public void tampilJumlah(int angka) {
        TextView txtJumlah = (TextView)findViewById(R.id.txtJumlah);
        txtJumlah.setText(angka + "");
    }
    public void tampilHarga(String pesan) {
        TextView txtHarga = (TextView)findViewById(R.id.txtHarga);
        txtHarga.setText(pesan);
    }
    public void pesan(View view) {
        String toppingGula = "";
        String toppingKrim = "";
        String toppingLollipop = "";
        String toppingKopi = "";
        Boolean checkGula = cbGula.isChecked();
        Boolean checkKrim = cbCream.isChecked();
        Boolean checkLollipop = cbLolipop.isChecked();
        Boolean checkKopi = cbKopi.isChecked();
        if(checkGula) {
            toppingGula = "Gula, ";
        }
        if(checkKrim) {
            toppingKrim = "Krim, ";
        }
        if(checkLollipop) {
            toppingLollipop = "Lollipop, ";
        }
        if(checkKopi) {
            toppingKopi = "Kopi";
        }
        int hargaTotal = tampilTotalHarga(checkGula, checkKrim, checkLollipop, checkKopi);
        String tampilkanHarga = tampilkanHarga(hargaTotal, toppingGula, toppingKrim, toppingLollipop, toppingKopi);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Laporan pemesanan");
        intent.putExtra(Intent.EXTRA_TEXT, tampilkanHarga);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        tampilHarga(tampilkanHarga);
        Toast.makeText(this, "Terima kasih", Toast.LENGTH_SHORT).show();
    }
    public void tambah(View view) {
        jumlahKopi += 1;
        tampilJumlah (jumlahKopi);
    }

    public void kurang(View view) {
        if (jumlahKopi == 0) {
            Toast.makeText(MainActivity.this, "Tidak bisa kurang dari 0",
                    Toast.LENGTH_SHORT).show();
        } else {
            jumlahKopi -= 1;
            tampilJumlah (jumlahKopi);
        }
    }

    public String tampilkanHarga(int harga, String checkGula, String checkKrim, String checkLollipop, String checkKopi) {
        EditText edtNama = (EditText)findViewById(R.id.edtNama);
        String nama = edtNama.getText().toString();
        String pesannya = "Terima kasih, " + nama +  " telah membeli kopi \n";
        pesannya += "\nTopping = " + checkGula + checkKrim + checkLollipop + checkKopi;
        pesannya += "\nHarga = " + harga;
        return pesannya;
    }
    public int tampilTotalHarga(Boolean checkGula, Boolean checkKrim, Boolean checkLollipop, Boolean checkKopi) {
        int hargaAwal = 0;
        int hargaAkhir;

        if(checkGula) {
            hargaAwal += 2000;
        }
        if(checkKrim) {
            hargaAwal += 1500;
        }
        if(checkLollipop) {
            hargaAwal += 5000;
        }
        if(checkKopi) {
            hargaAwal += 3500;
        }
        hargaAkhir = jumlahKopi * hargaAwal;
        return hargaAkhir;
    }


}
