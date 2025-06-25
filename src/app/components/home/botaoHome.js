"use client"
import Link from "next/link";

export default function BotaoHome(props) {
    return (
        <Link href={props.href} className={props.className}>
            {props.titulo}
        </Link>
    );
}

