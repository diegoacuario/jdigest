package jdigest;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Formatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Util
{
	/**
	 * Returns a human-readable string representation of the given byte value
	 * 
	 * @param bytes the byte value to be converted to human-readable
	 * @return the human-readable string representation of the given byte value
	 */
	public static String getByteString(long bytes)
	{
		Formatter f = new Formatter();
		if(bytes >= (long)100 * 1024 * 1024 * 1024)
		{
			return f.format("%dGb", bytes / (1024 * 1024 * 1024)).toString();
		}
		else if(bytes >= 1024 * 1024 * 1024)
		{
			float gigabytes = (float)bytes / (1024 * 1024 * 1024);
			if(gigabytes >= 10.0)
				return f.format("%.1fGb", gigabytes).toString();
			else
				return f.format("%.2fGb", gigabytes).toString();
		}
		else if(bytes >= 100 * 1024 * 1024)
		{
			return f.format("%dMb", bytes / (1024 * 1024)).toString();
		}
		else if(bytes >= 1024 * 1024)
		{
			float megabytes = (float)bytes / (1024 * 1024);
			if(megabytes >= 10.0)
				return f.format("%.1fMb", megabytes).toString();
			else
				return f.format("%.2fMb", megabytes).toString();
		}
		else if(bytes >= 100 * 1024)
		{
			return f.format("%dKb", bytes / 1024).toString();
		}
		else if(bytes >= 1024)
		{
			float kilobytes = (float)bytes / 1024;
			if(kilobytes >= 10.0)
				return f.format("%.1fKb", kilobytes).toString();
			else
				return f.format("%.2fKb", kilobytes).toString();
		}
		else
			return f.format("%dbytes", bytes).toString();
	}

	public static int getDefaultGap(JComponent component1,
		JComponent component2, LayoutStyle.ComponentPlacement type,
		int position, Container parent)
	{
		return LayoutStyle.getInstance().getPreferredGap(
			component1, component2, type, position, parent);		
	}

	public static Component createHorizontalRigidArea(JComponent component1,
		JComponent component2, Container parent)
	{
		Dimension d = new Dimension(
			getDefaultGap(component1, component2,
				LayoutStyle.ComponentPlacement.RELATED,
				SwingConstants.EAST, parent)
			,0);
		return Box.createRigidArea(d);
	}

	public static int getDefaultGap(JComponent component,
		int position, Container parent)
	{
		return LayoutStyle.getInstance().getContainerGap(
			component, position, parent);
	}

	public static Border createEmptyBorder(JComponent component,
		Container parent)
	{
		return BorderFactory.createEmptyBorder(
			getDefaultGap(component, SwingConstants.SOUTH, parent),
			getDefaultGap(component, SwingConstants.EAST, parent),
			getDefaultGap(component, SwingConstants.NORTH, parent),
			getDefaultGap(component, SwingConstants.WEST, parent));
	}

	// Plagiarized from Apache Commons
	public static boolean isSymlink(File file) throws IOException
	{
		File fileInCanonicalDir = null;
		if(file.getParent() == null)
			fileInCanonicalDir = file;
		else
		{
			File canonicalDir = file.getParentFile().getCanonicalFile();
			fileInCanonicalDir = new File(canonicalDir, file.getName());
		}
		return !fileInCanonicalDir.getCanonicalFile().equals(
			fileInCanonicalDir.getAbsoluteFile());
	}
}
