
import java.util.ArrayList;
import org.newdawn.slick.*;

public class RockBlast extends BasicGame {
    ArrayList<Astroid> rocks;
    
    public RockBlast(String title) {
        super(title);
    }

    public void init(GameContainer gc) throws SlickException {
        rocks = new ArrayList();
        Astroid.setGameSize(800,600);
        //get 10 asteroids
        for (int i = 0; i < 10; i++) {
            int rx = (int) (Math.random() * 750);
            int ry = (int) (Math.random() * 550);
            rocks.add(new Astroid(rx, ry));
        }
    }

    public void update(GameContainer gc, int i) throws SlickException {
        
        Input in = gc.getInput();
        int mx = gc.getInput().getMouseX();
        int my = gc.getInput().getMouseY();
        
        for (Astroid a : rocks) {
            a.move();
        }
        
        for(Astroid a : rocks){
            if(a.hit(mx, my) && in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
                rocks.remove(a);
                break;
            }
        }
    }

    public void render(GameContainer gc, Graphics g) throws SlickException {
        for (Astroid a : rocks) {
            a.draw();
        }
    }

    public static void main(String args[]) throws SlickException {
        RockBlast game = new RockBlast("Testing Game");
        AppGameContainer app = new AppGameContainer(game);
        app.setDisplayMode(800, 600, false);
        app.setShowFPS(false);
        app.setTargetFrameRate(100);
        app.start();
    }

}
