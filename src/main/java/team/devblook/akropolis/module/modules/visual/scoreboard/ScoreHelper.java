/*
 * This file is part of Akropolis
 *
 * Akropolis free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Akropolis is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Akropolis. If not, see <http://www.gnu.org/licenses/>.
 */

package team.devblook.akropolis.module.modules.visual.scoreboard;

import net.kyori.adventure.text.Component;
import net.megavex.scoreboardlibrary.api.sidebar.Sidebar;
import org.bukkit.entity.Player;
import team.devblook.akropolis.AkropolisPlugin;
import team.devblook.akropolis.util.PlaceholderUtil;

import java.util.List;

public class ScoreHelper {
    private final Sidebar sidebar;
    private final Player player;

    public ScoreHelper(Player player) {
        this.player = player;
        this.sidebar = AkropolisPlugin.getInstance().getScoreboardManager().sidebar(Sidebar.MAX_LINES);
    }

    public void setTitle(String title) {
        sidebar.title(setPlaceholders(title));
    }

    public void setSlotsFromList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            sidebar.line(i, setPlaceholders(list.get(i)));
        }
    }

    public Component setPlaceholders(String text) {
        return PlaceholderUtil.setPlaceholders(text, player);
    }

    public void addPlayer() {
        sidebar.addPlayer(player);
    }

    public void removePlayer() {
        sidebar.removePlayer(player);
    }


    public void visible(boolean visible) {
        sidebar.visible(visible);
    }
}