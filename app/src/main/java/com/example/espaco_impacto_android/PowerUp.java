package com.example.espaco_impacto_android;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

public class PowerUp extends Actor {

    private CurrentScene currentScene;

    PowerUp(int x, int y, Context c)
    {

        c.getResources();
        this.x = x;
        this.y = y;
        this.speedX = 3;
        this.speedY = 3;
        this.c = c;
        new BitmapFactory();
        this.img = BitmapFactory.decodeResource(this.c.getResources(), R.drawable.power_cd);
        this.height = img.getHeight();
        this.width = img.getWidth();
        currentScene = new CurrentScene(c);
    }

    @Override
    protected void draw(Canvas canvas, Paint painter)
    {
        canvas.drawRect(new Rect(0, 480, currentScene.getScreenW()/15 * 3, currentScene.getScreenH()/15), painter);
        canvas.drawBitmap(img, this.x, this.y, painter);
    }

    private void Movement()
    {
        this.x += speedX;
        this.y += speedY;
    }

    public void Collision()
    {
        if(this.y > currentScene.getScreenH() - (this.height * 1.5f) || this.y < 0)
        {
            this.speedY *= -1;
        }

        if(this.x > currentScene.getScreenW() - (this.width * 1.5f) || this.x < 0)
        {
            this.speedX *= -1;
        }
        else if(this.x < currentScene.getScreenW())
            this.speedX *= 1;


    }

    public void Update(Ship ship){

        for(int i = 0; i < ship.getShots().size(); i++)
        {
            if(Collision4(this, ship.getShots().get(i)))
            {
                ship.setCanShot(true);
            }
        }


        Movement();
        Collision();
    }
}
