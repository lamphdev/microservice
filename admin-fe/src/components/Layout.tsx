import AppBar from "./AppBar";
import LeftMenu from "./LeftMenu";

export default function Layout({ children }: { children: any }) {
  return (
    <div className="w-full, h-screen bg-background">
      <LeftMenu></LeftMenu>
      <div className="layout-content h-full">
        <AppBar></AppBar>
        <div className="h-full p-2 overflow-y-auto">{children}</div>
      </div>
    </div>
  );
}
