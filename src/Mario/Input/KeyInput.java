package Mario.Input;
import Mario.Entity.Entity;
import Mario.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for(Entity en : Game.handler.entity){
        switch (key){
            case KeyEvent.VK_W:
                if(!en.jumping ) {
                    en.jumping = true;
                    en.gravity = 10.0;
                }
                break;
//                en.setVely(-5);
//            case KeyEvent.VK_S:
//                en.setVely(5);
//                break;
            case KeyEvent.VK_A:
                en.setVelx(-5);
                break;
            case KeyEvent.VK_D:
                en.setVelx(5);
                break;
        }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for(Entity en : Game.handler.entity){
            switch (key){
                case KeyEvent.VK_W:
                    en.setVely(0);
                    break;
                case KeyEvent.VK_S:
                    en.setVely(0);
                    break;
                case KeyEvent.VK_A:
                    en.setVelx(0);
                    break;
                case KeyEvent.VK_D:
                    en.setVelx(0);
                    break;
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
