package xyz.yangxz.net_tankgame.Model;

public class TankThread extends Thread{
	public Tank enemy;
	
	public TankThread(Tank enemy) {
		this.enemy=enemy;
		enemy.moving=true;
	}
	
	public void run() {
		WarData.tanks.add(enemy);
		
		while(!enemy.destroyed) {
            try {
				sleep((long) (Math.random()*1000+1000));
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				return;
			}
            Bullet bullet = new Bullet(enemy.team, 8,enemy.x,enemy.y,enemy.direction);
            WarData.addBullet(bullet);
		}
		WarData.tanks.remove(enemy);
		WarData.dead_enemy++;
	}
}
