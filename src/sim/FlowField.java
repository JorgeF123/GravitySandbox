package sim;
import java.util.Random;

// Represents a grid of direction vectors that guide particle movement
class FlowField {
    int cols;
    int rows;
    int cellSize;
    Vec2[][] grid;
    Random rand = new Random();

    public FlowField(int w, int h, int cS){
        cellSize = cS;
        cols = (int) Math.ceil((double) w / cS);    // total columns
        rows = (int) Math.ceil((double) h / cS);    // total rows
        grid = new Vec2[cols][rows];

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                // pick a random angle between 0 and 2π radians
                float randomValue = rand.nextFloat();       
                float angle = (float) (randomValue * 2 * Math.PI); 
                
                // convert angle into a direction vector
                float dirX = (float) Math.cos(angle);
                float dirY = (float) Math.sin(angle);

                // store vector in the grid cell
                grid[x][y] = new Vec2(dirX, dirY);
            }
        }       
    }

    public Vec2 getForceAt(float x, float y){
        // find which cell the position falls into
        int c = (int) Math.floor(x / cellSize);
        int r = (int) Math.floor(y / cellSize);
        
        // keeps you inside the valid grid range
        c = Math.max(0, Math.min(c, cols - 1));
        r = Math.max(0, Math.min(r, rows - 1));

        return grid[c][r];  // Return the vector from that cell
        
    }

}
