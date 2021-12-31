import { Activity } from "./activity";
import { User } from "./user";

export class UserActivity {
    userActivityId:number;
	startDate:Date;
	status:String;
	user:User;
	activity:Activity;
}
