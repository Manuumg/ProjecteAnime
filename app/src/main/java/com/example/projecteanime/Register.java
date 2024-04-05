
package com.example.projecteanime;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Register {
    private Context context;

    public Register(Context context) {
        this.context = context;
    }

    public void loginUser(String email, String password) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://joanseculi.com/edt69/loginuser.php";
        JSONObject postData = new JSONObject();
        try {
            postData.put("email", email);
            postData.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }



        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, postData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            
                            String id = response.getString("id");
                            String name = response.getString("name");
                            String email = response.getString("email");
                            String password = response.getString("password");
                            String phone = response.getString("phone");

                            // Haz lo que necesites con los datos del usuario
                            Log.d("Login", "User details: " + id + ", " + name + ", " + email + ", " + password + ", " + phone);
                            Toast.makeText(context, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Maneja errores de la solicitud
                        Log.e("Login", "Error: " + error.toString());
                        Toast.makeText(context, "Error al iniciar sesión", Toast.LENGTH_SHORT).show();
                    }
                });

        
        queue.add(jsonObjectRequest);
    }
}

