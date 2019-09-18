package com.example.espaco_impacto_android;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class GameOver extends Scene{

	private CurrentScene currentScene;

	public GameOver(Context c) {
		super(c);
		img = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.bg);
        currentScene = new CurrentScene(c);
	}

	@Override
	protected void draw(Canvas canvas) {

        canvas.drawBitmap(img, 0, 0, painter[0]);
		Record record = new Record(this.c);
		drawCenter(canvas, painter[0], "Record: " + record.getRecordString());
	}

	@Override
	protected void MotionEvent(MotionEvent event) {
		int action = event.getAction();
		if (action == MotionEvent.ACTION_DOWN) {
			currentScene.setCanInstantiate(true);
			currentScene.setChangeScene("menu");
		}
	}

	@Override
	protected void Update() {

	}
}
