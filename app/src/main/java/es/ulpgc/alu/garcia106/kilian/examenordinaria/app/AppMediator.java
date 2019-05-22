package es.ulpgc.alu.garcia106.kilian.examenordinaria.app;

import android.app.Application;

import es.ulpgc.alu.garcia106.kilian.examenordinaria.detail.DetailState;
import es.ulpgc.alu.garcia106.kilian.examenordinaria.master.MasterState;

public class AppMediator extends Application {

  private MasterState masterState;

  private DetailState detailState;

  public AppMediator(){
    this.masterState = new MasterState();
    this.detailState = new DetailState();
  }

  public MasterState getMasterState() {
    return masterState;
  }

  public void setMasterState(MasterState masterState) {
    this.masterState = masterState;
  }

  public DetailState getDetailState() {
    return detailState;
  }

  public void setDetailState(DetailState detailState) {
    this.detailState = detailState;
  }
}
