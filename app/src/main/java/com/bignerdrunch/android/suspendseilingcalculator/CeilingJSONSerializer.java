package com.bignerdrunch.android.suspendseilingcalculator;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by ar4er25 on 2/16/2017.
 */

public class CeilingJSONSerializer {
    private Context mContext;
    private String mFileName;

    public CeilingJSONSerializer(Context c, String f){
        mContext = c;
        mFileName = f;
    }
    public void saveCeylings(ArrayList<SuspendCeiling>ceilings) throws JSONException, IOException{
        JSONArray array = new JSONArray();
        for (SuspendCeiling sc: ceilings){
            array.put(sc.toJSON());
        }
        Writer writer = null;
        try {
            OutputStream out = mContext.openFileOutput(mFileName, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        }finally {
            if (writer!=null)
                writer.close();
        }
    }
    public ArrayList<SuspendCeiling> loadCrimes() throws IOException, JSONException {
        ArrayList<SuspendCeiling> ceilings = new ArrayList<>();
        BufferedReader reader = null;
        try {
            InputStream in = mContext.openFileInput(mFileName);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine())!=null){
                jsonString.append(line);
            }
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            for (int i = 0; i <array.length() ; i++) {
                ceilings.add(new SuspendCeiling(array.getJSONObject(i)));
            }
        }catch (FileNotFoundException e){}
        finally {
            if (reader!=null)
                reader.close();
        }
        return ceilings;
    }

}
