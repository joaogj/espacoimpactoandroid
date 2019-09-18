package com.example.espaco_impacto_android;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Game extends Scene
{

	private Ship ship;
	private EnemyManager EnemyManager;
	private PowerUp power;
	private CurrentScene currentScene;
	private CurrentSceneActivity currentSceneActivity;


	Game(Context c) {
		super(c);
		currentScene = new CurrentScene(c);
		currentSceneActivity = new CurrentSceneActivity();
		new BitmapFactory();
		img = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.bg);
		ship = new Ship(0, currentScene.getScreenH()/2, this.c);
		EnemyManager = new EnemyManager(this.c);
		power = new PowerUp(currentScene.getScreenW()/2, currentScene.getScreenH()/2, this.c);

	}

	@Override
	protected void draw(Canvas canvas) {
        canvas.drawBitmap(img, 0, 0, painter[0]);
		ship.draw(canvas,painter[1]);	
		power.draw(canvas, painter[1]);
		EnemyManager.draw(canvas, painter[1]);

		canvas.drawText("Record: " + ship.getRecord().getRecordString(), (float) (currentScene.getScreenW()/1.4), (currentScene.getScreenH()/13.0f), painter[0]);
		canvas.drawText("Score: " + ship.getScore(), (float) (currentScene.getScreenW()/1.4), (currentScene.getScreenH()/7.0f), painter[0]);

	}

	@Override
	protected void MotionEvent(android.view.MotionEvent event) {
		ship.MotionEvent(event);
	}

	@Override
	protected void Update() {
		this.ship.Update((float) (currentSceneActivity.getY() * 1.5));
		power.Update(ship);
		EnemyManager.Update(ship);
	}

}
