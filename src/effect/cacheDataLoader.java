package effect;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;



import gameObject.physicalMap;

public class cacheDataLoader {
	private static cacheDataLoader instance;
	private String framefile = "data/frame.txt";
	private String animationfile = "data/animation.txt";
	private Hashtable<String, frameImage> frameImages;
	private Hashtable<String, animation> animations;
	private String physmapfile = "data/phys_map.txt";

	private int[][] phys_map;

	public void LoadPhysMap() throws IOException {

		FileReader fr = new FileReader(physmapfile);
		BufferedReader br = new BufferedReader(fr);

		String line = null;

		line = br.readLine();
		int numberOfRows = Integer.parseInt(line);
		line = br.readLine();
		int numberOfColumns = Integer.parseInt(line);
		instance.phys_map = new int[numberOfRows][numberOfColumns];
		for (int i = 0; i < numberOfRows; i++) {
			line = br.readLine();
			String[] str = line.split(" ");
			for (int j = 0; j < numberOfColumns; j++)
				instance.phys_map[i][j] = Integer.parseInt(str[j]);
		}
		for (int i = 0; i < numberOfRows; i++) {

			for (int j = 0; j < numberOfColumns; j++)
				System.out.print(" " + instance.phys_map[i][j]);
			System.out.println();
		}
		br.close();
	}

	public frameImage getFrameImage(String name) {
		frameImage f = new frameImage(instance.frameImages.get(name));
		return f;
	}

	public static cacheDataLoader getInstance() {
		if(instance == null)
            instance  = new cacheDataLoader();
        return instance;
	}

// muc dich de load 
	public void LoadFrame() throws IOException {
		frameImages = new Hashtable<String, frameImage>();
		FileReader fr = new FileReader(framefile);
		BufferedReader br = new BufferedReader(fr);
		String line = null;

		if (br.readLine() == null) {
			System.out.println("No data");
			throw new IOException();
		} else {

			fr = new FileReader(framefile);
			br = new BufferedReader(fr);

			while ((line = br.readLine()).equals(""))
				;
			int n = Integer.parseInt(line);
			String path = null;
			BufferedImage imageData = null;
			int i2 = 0;
			for (int i = 0; i < n; i++) {
				frameImage frame = new frameImage();
				while ((line = br.readLine()).equals(""))
					;
				frame.setName(line);

				while ((line = br.readLine()).equals(""))
					;
				String[] str = line.split(" ");

				boolean refreshImage = (path == null || !path.equals(str[1]));
				path = str[1];
				while ((line = br.readLine()).equals(""))
					;
				str = line.split(" ");
				int x = Integer.parseInt(str[1]);
				while ((line = br.readLine()).equals(""))
					;
				str = line.split(" ");
				int y = Integer.parseInt(str[1]);

				while ((line = br.readLine()).equals(""))
					;
				str = line.split(" ");
				int w = Integer.parseInt(str[1]);

				while ((line = br.readLine()).equals(""))
					;
				str = line.split(" ");
				int h = Integer.parseInt(str[1]);

				if (refreshImage) {
					refreshImage = false;
					imageData = ImageIO.read(new File(path));
				}
				if (imageData != null) {

					BufferedImage image = imageData.getSubimage(x, y, w, h);
					frame.setImage(image);
				}

				instance.frameImages.put(frame.getName(), frame);
			}
		}

		br.close();

	}

	public animation getAnimation(String name) {
		animation animation = new animation(instance.animations.get(name));
		return animation;
	}

	public void LoadAnimation() throws IOException {
		animations = new Hashtable<String, animation>();
		FileReader fr = new FileReader(animationfile);
		BufferedReader br = new BufferedReader(fr);
		String line = null;

		if (br.readLine() == null) {
			System.out.println("No data");
			throw new IOException();
		} else {

			fr = new FileReader(animationfile);
			br = new BufferedReader(fr);

			while ((line = br.readLine()).equals(""))
				;
			int n = Integer.parseInt(line);

			for (int i = 0; i < n; i++) {

				animation animation = new animation();

				while ((line = br.readLine()).equals(""))
					;
				animation.setName(line);

				while ((line = br.readLine()).equals(""))
					;
				String[] str = line.split(" ");

				for (int j = 0; j < str.length; j += 2) {
					animation.add(getFrameImage(str[j]), Double.parseDouble(str[j + 1]));
				}
				instance.animations.put(animation.getName(), animation);
			}
		}
		br.close();
	}
	public int[][] getPhysicalMap() {
		return instance.phys_map;
	}
	public void LoadData() throws IOException {
		LoadFrame();
		LoadAnimation();
		LoadPhysMap();
		//System.out.println(instance.phys_map);
	}

}