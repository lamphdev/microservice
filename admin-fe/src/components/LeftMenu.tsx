export default function LeftMenu() {
  return (
    <nav className="fixed h-screen layout-nav rounded-md bg-primary top-0 left-0">
      <ul>
        <li className="block w-full p-2 hover:opacity-70">
          <a href="f" className="text-text">
            Content
          </a>
        </li>
        <li className="block w-full p-2 hover:opacity-70">
          <a href="f" className="text-text">
            About
          </a>
        </li>
        <li className="block w-full p-2 hover:opacity-70">
          <a href="f" className="text-text">
            Setting
          </a>
        </li>
        <li className="block w-full p-2 hover:opacity-70">
          <a href="f" className="text-text">
            Note
          </a>
        </li>
        <li className="block w-full p-2 hover:opacity-70">
          <a href="f" className="text-text">
            News
          </a>
        </li>
        <li className="block w-full p-2 hover:opacity-70">
          <a href="f" className="text-text">
            Layout
          </a>
        </li>
      </ul>
    </nav>
  );
}
