package es.ulpgc.alu.garcia106.kilian.examenordinaria.app;

import android.app.Application;

import es.ulpgc.alu.garcia106.kilian.examenordinaria.master.MasterState;

public class AppMediator extends Application {

  private MasterState masterState;

  public AppMediator(){
    this.masterState = new MasterState();
  }

  public MasterState getMasterState() {
    return masterState;
  }

  public void setMasterState(MasterState masterState) {
    this.masterState = masterState;
  }
}
