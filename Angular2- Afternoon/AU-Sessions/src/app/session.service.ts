import { Injectable } from '@angular/core';
import {Session} from "./modal/session";

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  sessionItems: Session[] = [
    {
      name : 'session-1',
      instructor : 'instructor-1',
      desc : 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet dolores ea harum hic itaque iusto minima optio quis\n' +
        '  rem sequi ut veritatis, vero! Dolores laborum mollitia nisi omnis tempora veritatis. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam consequuntur deserunt distinctio laborum\n' +
        '  molestiae nisi omnis, sit vero. Iste necessitatibus nisi quo recusandae! '
    },
    {
      name : 'session-2',
      instructor : 'instructor-2',
      desc : 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet dolores ea harum hic itaque iusto minima optio quis\n' +
        '  rem sequi ut veritatis, vero! Dolores laborum mollitia nisi omnis tempora veritatis.Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam consequuntur deserunt distinctio laborum\n' +
        '  molestiae nisi omnis, sit vero. Iste necessitatibus nisi quo recusandae! '
    },
    {
      name : 'session-3',
      instructor : 'instructor-3',
      desc : 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet dolores ea harum hic itaque iusto minima optio quis\n' +
        '  rem sequi ut veritatis, vero! Dolores laborum mollitia nisi omnis tempora veritatis.Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam consequuntur deserunt distinctio laborum\n' +
        '  molestiae nisi omnis, sit vero. Iste necessitatibus nisi quo recusandae! '
    }
  ];


  constructor() { }

  getSession()
  {
    return this.sessionItems;
  }

  addSession(ses: Session)
  {
    this.sessionItems.push(ses);
  }

  removeSession(name: string)
  {
    this.sessionItems = this.sessionItems.filter((item) => item.name !== name);

    console.log(this.sessionItems);
  }

  modifySession(ses: Session)
  {
    this.sessionItems = this.sessionItems.map((item) => {
      if ((ses.name === item.name) || (ses.desc === item.desc) || (ses.instructor === item.instructor)) {
        return ses;
      }
      else {
        return item;
      }
    });
  }
}
