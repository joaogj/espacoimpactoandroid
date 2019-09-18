package com.example.espaco_impacto_android;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class Menu extends Scene{

	private CurrentScene currentScene;

	public Menu(Context c) {
		super(c);
		img = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.bg);
		currentScene = new CurrentScene(c);
	}
	
	@Override
	protected void draw(Canvas canvas) {

		//canvas.drawText("MENU", CurrentScene.screenW/2 - painter.getTextSize(), CurrentScene.screenH/2, painter);
		canvas.drawBitmap(img, 0, 0, painter[0]);
		drawCenter(canvas, painter[1], "JOGAR");
		canvas.drawText("João Gabriel", 0, (float) (currentScene.getScreenH()/1.6), painter[0]);
		canvas.drawText("João Vítor", 0, (float) (currentScene.getScreenH()/1.4), painter[0]);
		canvas.drawText("Matheus Escovino", 0, (float) (currentScene.getScreenH()/1.25), painter[0]);
	}

	@Override
	protected void MotionEvent(MotionEvent event) {

		int action = event.getAction();

		if (action == MotionEvent.ACTION_DOWN) {
			currentScene.setCanInstantiate(true);
			currentScene.setChangeScene("game");
		}
	}

	@Override
	protected void Update() {
	}

}
