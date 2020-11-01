import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';


export enum LogLevel {
  All = 0,
  Debug = 1,
  Info = 2,
  Warn = 3,
  Error = 4,
  Fatal = 5,
  Off = 6
}

export class LogEntry {
  // Public Properties
  entryDate: Date = new Date();
  message: string = "";
  level: LogLevel = environment.logLevel;
  extraInfo: any[] = [];
  logWithDate: boolean = true;

  buildLogString(): string {
    if (this.shouldLog(this.level)) {
      let ret: string = "";

      // if (this.logWithDate) {
      //   ret = new Date() + " - ";
      // }
      ret += "Type: " + LogLevel[this.level];
      ret += " - Message: " + this.message;
      if (this.extraInfo.length) {
        ret += " - Extra Info: "
          + this.formatParams(this.extraInfo);
      }
      // Log the value
      console.log(ret);
      return ret;
    }
  }
  //this method is used to create a comma-delimited list of the parameter array.
  private formatParams(params: any[]): string {
    let ret: string = params.join(",");

    // Is there at least one object in the array?
    if (params.some(p => typeof p == "object")) {
      ret = "";
      // Build comma-delimited string
      for (let item of params) {
        ret += JSON.stringify(item) + ",";
      }
    }

    return ret;
  }
  //the shouldLog() method determines if logging should occur based on the level property 
  private shouldLog(level: LogLevel): boolean {
    let ret: boolean = false;
    if ((level >= this.level &&
      level !== LogLevel.Off) ||
      this.level === LogLevel.All) {
      ret = true;
    }
    return ret;
  }
}

@Injectable({
  providedIn: 'root'
})

export class LogService {
  level: LogLevel = LogLevel.All;  //default value to the All enumeration 0
  constructor() { }

  log(msg: any, ...optionalParams: any[]) {
    let logEntry = new LogEntry();
    logEntry.message = msg;
    logEntry.extraInfo = optionalParams;
    logEntry.level = LogLevel.All;
    logEntry.buildLogString();
  }

  debug(msg: string, ...optionalParams: any[]) {
    // this.writeToLog(msg, LogLevel.Debug, optionalParams);
    let logEntry = new LogEntry();
    logEntry.message = msg;
    logEntry.extraInfo = optionalParams;
    logEntry.level = LogLevel.Debug;
    logEntry.buildLogString();
  }

  info(msg: string, ...optionalParams: any[]) {
    let logEntry = new LogEntry();
    logEntry.message = msg;
    logEntry.extraInfo = optionalParams;
    logEntry.level = LogLevel.Info;
    logEntry.buildLogString();

  }

  warn(msg: string, ...optionalParams: any[]) {
    let logEntry = new LogEntry();
    logEntry.message = msg;
    logEntry.extraInfo = optionalParams;
    logEntry.level = LogLevel.Warn;
    logEntry.buildLogString();
  }

  error(msg: string, ...optionalParams: any[]) {
    let logEntry = new LogEntry();
    logEntry.message = msg;
    logEntry.extraInfo = optionalParams;
    logEntry.level = LogLevel.Error;
    logEntry.buildLogString();
  }

  fatal(msg: string, ...optionalParams: any[]) {
    let logEntry = new LogEntry();
    logEntry.message = msg;
    logEntry.extraInfo = optionalParams;
    logEntry.level = LogLevel.Fatal;
    logEntry.buildLogString();
  }

}
