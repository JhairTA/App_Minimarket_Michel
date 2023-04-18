package com.example.proyecto_final.Activity;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.Duration;
import com.google.maps.model.TravelMode;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.example.proyecto_final.R;


public class MainActivity2 extends AppCompatActivity implements OnMapReadyCallback {

    public static final int REQUEST_CODE_AUTOCOMPLETE_TO = 2;
    private Marker mMarkerFrom=null;
    private Marker mMarkerTo=null;
    private GoogleMap mMap;
    private LatLng mToLatLng;
    private String origen,destino;
    private GeoApiContext mGeoApiContext;
    public static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupMap();
        setupPlaces();
        Button btnCalcular = findViewById(R.id.btnCalcular);
        mGeoApiContext = new GeoApiContext.Builder()
                .apiKey("AIzaSyAw8OTWD6Qotm_4oUEacsIZEdcmjEsAzVY")
                .build();
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularDistanciaTiempo();
            }
        });
    }

    private void setupMap(){
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    private void setupPlaces(){
        Button btnTo= (Button)findViewById(R.id.btnTo) ;
        TextView tvTo= (TextView) findViewById(R.id.tvTo) ;
        Places.initialize(getApplicationContext(), getString(R.string.android_sdk_places_api_key));
        btnTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAutocomplete(REQUEST_CODE_AUTOCOMPLETE_TO);
                Log.e("paso por aqui", "onclick");
            }
        });
        tvTo.setText(getString(R.string.label_to)+getString(R.string.no_place_selected));
    }
    private void startAutocomplete(int requestCode ){

        List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG, Place.Field.ADDRESS);

        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                .build(getApplicationContext());

        startActivityForResult(intent, requestCode);
    }



    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_AUTOCOMPLETE_TO) {
            if (resultCode == RESULT_OK) {

                Place place = Autocomplete.getPlaceFromIntent(data);
                Log.i(TAG, "Place: " + place);

                TextView tvTo= (TextView) findViewById(R.id.tvTo) ;
                TextView tvidTo= (TextView) findViewById(R.id.tvidTo) ;
                tvTo.setText(getString(R.string.label_to,place.getName()));
                tvidTo.setText(place.getId());
                if (place.getLatLng() != null) {
                    mToLatLng = place.getLatLng();
                    setMarkerTo(mToLatLng);
                }

            } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                // TODO: Handle the error.
                Status status = Autocomplete.getStatusFromIntent(data);
                Log.i(TAG, status.getStatusMessage());
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMinZoomPreference(10f);
        mMap.setMaxZoomPreference(15f);
        LatLng origen=new LatLng(-12.177743907469273, -77.01006386977923);
        mMarkerFrom= addMarker(origen,getString(R.string.marker_title_from));

    }

    public Marker addMarker(LatLng latlng,String title){
        MarkerOptions marketOptions = new MarkerOptions().position(latlng)
                .title(title);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        return mMap.addMarker(marketOptions);
    }

    private void setMarkerTo(LatLng latLng){
        if (mMarkerTo != null) {
            mMarkerTo.remove();
        }
        mMarkerTo=addMarker(latLng,getString(R.string.marker_title_to));

    }

    private void calcularDistanciaTiempo() {
        // Crear un objeto GeoApiContext con tu clave de API de Google Maps
        origen =  "EitBdi4gQXJpb3N0byBNYXRlbGxpbmkgMTU3LCBMaW1hIDE1MDY0LCBQZXJ1IjESLwoUChIJSyK26tW5BZER0oybaW2XugUQnQEqFAoSCdutYFR8twWREanJrbzEbdg6";
        TextView destino1=findViewById(R.id.tvidTo);
        TextView tiempo=findViewById(R.id.tvTime);
        destino =  destino1.getText().toString();
        DirectionsApiRequest request = DirectionsApi.newRequest(mGeoApiContext)
                .originPlaceId(origen)
                .destinationPlaceId(destino)
                .mode(TravelMode.DRIVING) // Modo de transporte (DRIVING, WALKING, BICYCLING o TRANSIT)
                .language("es") // Idioma de la respuesta
                .avoid(DirectionsApi.RouteRestriction.TOLLS);
        try {
            DirectionsResult result = request.await();
            DirectionsRoute ruta = result.routes[0];

            // Obtener la distancia y el tiempo de la ruta
            DirectionsLeg tramo = ruta.legs[0];
            Duration duracion = tramo.duration;
            String distancia = String.valueOf(tramo.distance);

            String mensaje = String.format(
                    duracion.humanReadable);
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
            tiempo.setText("Tiempo:"+mensaje);
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }
}