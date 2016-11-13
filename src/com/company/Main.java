package com.company;
import com.theeyetribe.clientsdk.GazeManager;
import com.theeyetribe.clientsdk.IConnectionStateListener;
import com.theeyetribe.clientsdk.IGazeListener;
import com.theeyetribe.clientsdk.ITrackerStateListener;
import com.theeyetribe.clientsdk.data.GazeData;
public class Main {
    public static void main(String[] args) {
        final GazeManager gm = GazeManager.getInstance();
        gm.addConnectionStateListener(new IConnectionStateListener() {
            @Override
            public void onConnectionStateChanged(boolean b) {
                System.out.println("" + b);
            }
        });
        gm.addTrackerStateListener(new ITrackerStateListener() {
            @Override
            public void onTrackerStateChanged(int i) {
                System.out.println(i);
            }
        });
        gm.addGazeListener(new IGazeListener() {
            @Override
            public void onGazeUpdate(GazeData gazeData) {
                System.out.println(gazeData.rawCoordinates.toString());
            }
        });
        boolean b = gm.activate();
        System.out.println(b);
    }
}