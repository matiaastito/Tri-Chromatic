package Controller;

import Models.Direction;
import Models.actor.Actor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

//Cuando se actualize el game screen tmb se actualizara el controller y decidira que hacer en base a los booleanos up down left right

public class ControllerActor extends InputAdapter {

    private Actor actor;

    private Body body;

    private boolean up, down, left, right;


    public ControllerActor(Actor actor) {
        this.actor = actor;
        this.body = actor.getBody();
    }


    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.W) {
            up = true;

        }
        if (keycode == Input.Keys.S) {
            down = true;

        }
        if (keycode == Input.Keys.D) {
            right = true;

        }
        if (keycode == Input.Keys.A) {
            left = true;

        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.W) {
            up = false;

        }
        if (keycode == Input.Keys.S) {
            down = false;

        }
        if (keycode == Input.Keys.D) {
            right = false;

        }
        if (keycode == Input.Keys.A) {
            left = false;

        }

        return false;

    }

 //de esta manera no se puede caminar de forma diagonal
    public void inputUpdateD (float delta)
    {
        int horizontalForce =0;
        int verticalForce =0;
        body.setLinearVelocity(0,0);
        if(up){
            verticalForce+=1;
            actor.move(Direction.NORTH);
            body.setLinearVelocity(body.getLinearVelocity().x, verticalForce * 2);
            return;

        }
        if(down) {
            verticalForce -= 1;
            actor.move(Direction.SOUTH);
            body.setLinearVelocity(body.getLinearVelocity().x, verticalForce * 2);
            return;
        }
        if(right){
            horizontalForce +=1;
            actor.move(Direction.EAST);
            body.setLinearVelocity(horizontalForce * 2, body.getLinearVelocity().y);
            return;
        }
         if(left){
             horizontalForce -=1;
             actor.move(Direction.WEST);
             body.setLinearVelocity(horizontalForce * 2, body.getLinearVelocity().y);
             return;
    }

    }
/*
    public void inputUpdateW (float delta){
        int verticalForce =0;
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            verticalForce+=1;
            actor.move(Direction.NORTH);

        }
         if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            verticalForce -= 1;
            actor.move(Direction.SOUTH);
        }



    }

 */



}