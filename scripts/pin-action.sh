#!/usr/bin/env bash
# Prints "<full commit SHA> # <tag>" for the latest release of a GitHub Action.
set -euo pipefail
repo="$1"
tag=$(gh release view --repo "$repo" --json tagName --jq .tagName)
read -r type sha < <(gh api "repos/$repo/git/ref/tags/$tag" --jq '.object.type + " " + .object.sha')
if [ "$type" = "tag" ]; then
  sha=$(gh api "repos/$repo/git/tags/$sha" --jq .object.sha)
fi
echo "$sha # $tag"
