import { Injectable } from "@angular/core";
import { Theme, blue, green } from "./theme";

@Injectable({
  providedIn: "root"
})
export class ThemeService {
  private active: Theme = blue;
  private availableThemes: Theme[] = [blue, green];

  getAvailableThemes(): Theme[] {
    return this.availableThemes;
  }

  getActiveTheme(): Theme {
    return this.active;
  }

  setGreenTheme(): void {
    this.setActiveTheme(green);
  }

  setBlueTheme(): void {
    this.setActiveTheme(blue);
  }

  setActiveTheme(theme: Theme): void {
    this.active = theme;

    Object.keys(this.active.properties).forEach(property => {
      document.documentElement.style.setProperty(
        property,
        this.active.properties[property]
      );
    });
  }
}
