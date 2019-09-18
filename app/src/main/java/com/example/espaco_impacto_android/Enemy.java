package com.example.espaco_impacto_android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Enemy
{
	protected Bitmap img;
	protected int x, y, height, width;
	protected Context c;
	private CurrentScene currentScene = new CurrentScene(c);
//	protected List<Shot> shots;

	protected abstract void draw(Canvas canvas,Paint painter);

	
	protected void Update(Ship ship){	
	}
	
	protected boolean Collision1(Enemy_Shoter actor, Enemy_Shoter actor2){
		if(actor.x + actor.width > actor2.x && actor.x < actor2.x + actor2.width &&
			actor.y + actor.height > actor2.y && actor.y < actor2.y + actor2.height ){
			return true;
		}else{
			return false;
		}
	}	
	
	protected boolean Collision2(Actor actor){
		if(actor.x < 0 || actor.x + actor.width > currentScene.getScreenW()  ||
				actor.y < 0 || actor.y + actor.height > currentScene.getScreenH() ){
			return true;
		}else{
			return false;
		}		
	}
	
	protected boolean Collision3(Actor actor){
		if(actor.x < 0 - actor.width ){
			return true;
		}else{
			return false;
		}		
	}

	protected boolean CollisionEnemy(Enemy enemy, Enemy enemy2){
		if(enemy.x + enemy.width > enemy2.x && enemy.x < enemy2.x + enemy2.width &&
				enemy.y + enemy.height > enemy2.y && enemy.y < enemy2.y + enemy2.height){
			return true;
		}
		else
			return false;
	}
}
